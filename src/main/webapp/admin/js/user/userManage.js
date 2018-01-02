/**
 * 用户管理
 */
class QueryParam {
	constructor() {
		this.username;
		this.realname;
		this.pageSize = 10;
		this.pageNum = 1;
	}
}

class User {
	constructor() {
		this.username;
		this.realname;
		this.password;
		this.sex;
		this.tel;
		this.locked;
	}
}
let param = new QueryParam();
let user = new User();
/*缓存结果集*/
let resultCache;
let currentUpdateUser;
let selectedArr = new Array();
let userModalSubmitType;

class QueryUser {
	static query(data) {
	    return new Promise((resolve) => {
	        $.ajax({
	            url: 'admin/systemManage/getUserList',
	            type: 'POST',
	            async: true,
	            contentType: "application/json; charset=utf-8",
	            data: JSON.stringify(data),
	            dataType: 'json'
	        }).then((result) => {
	            resolve(result);
	        });
	    });
	}
}

class OperationUser {
	static operation(data, type) {
		let url = "admin/systemManage/" + type;
		return new Promise((resolve) => {
            $.ajax({
                url: url,
                type: 'POST',
                async: true,
                contentType: "application/json; charset=utf-8",
                data: data,
                dataType: 'json'
            }).then((result) => {
                resolve(result);
            });
        });
	}
}

class DrawTable {
	static fillData(result) {
		$('#table-tbody').html('');
        let htmlValue = '';
        function getSex(val) {
            if (val == 0) {
                return '男';
            } else {
                return '女';
            }
        }
        function getLocked(val) {
            if (val == 0) {
                return '<span class="text-green">已启用</span>';
            } else {
                return '<span class="text-red">已停用</span>';
            }
        }
        function getLockedBtn(val, index) {
            if (val == 0) {
                return `<button class="btn btn-minier btn-yellow lock-user" data-id="${index}">停用</button>`;
            } else {
                return `<button class="btn btn-minier btn-green lock-user" data-id="${index}">启用</button>`;
            }
        }
        for (let i = 0; i < result.length; i++) {
        	
        	htmlValue +=
        	`<tr>
				<td class="center"><label class="position-relative">
						<input type="checkbox" class="ace checkbox-user" data-id="${result[i].id}"/> <span class="lbl"></span>
				</label></td>

				<td>${result[i].username}</td>
				<td>${result[i].realname}</td>
				<td>${getSex(result[i].sex)}</td>
				<td>${result[i].tel}</td>
				<td>${getLocked(result[i].locked)}</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
						${getLockedBtn(result[i].locked, i)}
						<button class="btn btn-minier btn-primary update-user" data-toggle="modal" data-id="${i}" data-target="#user-modal">修改</button>
						<button class="btn btn-minier btn-danger delete-user" data-id="${result[i].id}">删除</button>
					</div>
				</td>
			</tr>`;
        }
        $('#table-tbody').append(htmlValue);
	}
}

class PageInfo {
    static drawPageController(result) {
        let pageInfo = result.pageInfo;
        let currentPage = pageInfo.pageNum;
        let totalPages = pageInfo.navigatepageNums.length;
        let options = {
            bootstrapMajorVersion: 3,
            currentPage: currentPage,
            totalPages: totalPages,
            numberOfPages: 10,
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page) {
            	param.pageNum = page;
            	query(param);
            }
        }
        $('#page').bootstrapPaginator(options);
    }

}

function query(data) {
	QueryUser.query(data).then((result) => {
        console.log(result.pageInfo);
        selectedArr = new Array();
        if (result.pageInfo.list.length > 0) {
        	resultCache = result.pageInfo.list;
        	DrawTable.fillData(resultCache);
        	PageInfo.drawPageController(result);
        	$('#total-count').html(result.pageInfo.total);
        }
    });
}



queryDefault();
function queryDefault() {
	param.pageNum = 1;
	query(param);
}

function doOperation(userInfo, type) {
    $('#user-modal').modal('hide');
    $('.loading-word').html('正在提交...')
    $('.submit-loading').css('display', 'block');
    OperationUser.operation(JSON.stringify(userInfo), type).then((result) => {
        if (result.retcode == 1) {
            $('.loading-gif').attr('src', 'admin/img/submit_success.png');
            $('.loading-word').html('<span style="color: rgb(10, 180, 0)">' + '操作成功</span>');
            queryDefault();
        } else {
            $('.loading-gif').attr('src', 'admin/img/submit_fail.png');
            $('.loading-word').html('<span style="color: rgb(255, 120, 120);">' + '操作失败</span>');
        }
        setTimeout(function () {
            $('.submit-loading').fadeOut(600);
            $('.upload-video-btn').removeAttr('disabled');
        }, 1500);
    });
}

function onSearch() {
	param.pageNum = 1;
	param.username = $('#userNameSearch').val();
	param.realname = $('#realNameSearch').val();
	query(param);
}

function batchDel() {
	let ids = {ids:[]}
	if(selectedArr.length > 0){
		ids.ids = selectedArr;
		doOperation(ids, 'deleteUser');
	} else {
		alert("请先勾选！");
	}
	
}
function addUser() {
    let userInfo = new User();//
    userInfo.username = $('#username').val().replace(/(^\s*)|(\s*$)/g, "");
    userInfo.password = $('#password').val();
    userInfo.realname = $('#realname').val().replace(/(^\s*)|(\s*$)/g, "");
    userInfo.tel = $('#tel').val().replace(/(^\s*)|(\s*$)/g, "");
    userInfo.sex = $("input[name='sex']:checked").val();
    if (userInfo.username != '' && userInfo.password != '' && userInfo.realname != '' && userInfo.tel != '' && userInfo.sex != '') {
    	doOperation(userInfo, 'addUser', '添加');
    } else {
        alert('信息未输入完整');
    }
}

function updateUser() {//currentUpdateUser
    let userInfo = currentUpdateUser;
    userInfo.realname = $('#realname').val().replace(/(^\s*)|(\s*$)/g, "");
    userInfo.password = $('#password').val();
    userInfo.tel = $('#tel').val().replace(/(^\s*)|(\s*$)/g, "");
    userInfo.sex = $("input[name='sex']:checked").val();
    doOperation(userInfo, 'updateUser', '修改');
}

function confirmModal(type, content, data) {
	$('#modal-alert-content').html(content);
    $('#confirm-modal').modal('show');
    $('#confirm-modal-submit').unbind("click");
    $('#confirm-modal-submit').click(function () {
        $('#confirm-modal').modal('hide');
        switch (type) {
            case 'deleteUser':
                doOperation(data, 'deleteUser');
                break;
            case 'lockUser':
            	doOperation(data, 'updateUser');
            default:
                break;
        }
        $('#confirm-modal-submit').unbind("click");
    });
}

/* 选择每页显示数量*/
$(function(){
	$('#total-count-selector').change(function () {
	    param.pageNum = 1;
	    param.pageSize = $(this).val();
	    query(param);
	});
});
/* type=1为添加用户，type=2为修改信息*/
function openUserModal(userInfo, type) {
    if (type == 1) {
        $('#user-modal-title').html('新增用户');
        $('#username').val('');
        $('#realname').val('');
        $('#tel').val('');
        $('#sex').html('&nbsp;');
        $('#password').css('display', '');
        $('#username-input').removeAttr('disabled');
        $('.user-modal-submit').html('确认添加');
        userModalSubmitType = 1;
    } else {
        $('#user-modal-title').html('修改信息');
        $('#username').val(userInfo.username);
        $('#realname').val(userInfo.realname);
        $('#tel').val(userInfo.tel);
        $('#username').attr('disabled', 'disabled');
        if (userInfo.sex == 0) {
        	$("input:radio[value=0]").attr('checked','true');
        } else {
        	$("input:radio[value=1]").attr('checked','true');
        }
        $('.user-modal-submit').html('确认修改');
        userModalSubmitType = 2;
    }
}

$(document).on('change', '.checkbox-user-all', function(){
	if($(this).is(':checked')) {
		$('.checkbox-user').each(function() {
			$(this).prop('checked', true);
		});
	} else {
		$('.checkbox-user').each(function() {
			$(this).prop('checked', false);
		});
	}
	$('.checkbox-user').each(function() {
		$(this).change();
	});
});
/* 选择框 */
$(document).on('change', '.checkbox-user', function () {
	let selectId =  parseInt($(this).attr('data-id'));
	let currentIndex = $.inArray(selectId, selectedArr);
	if($(this).is(':checked')) {
		if(currentIndex ==-1) {
			selectedArr.push(selectId);
		}
	} else {
		if(currentIndex>-1) {
			selectedArr.splice(currentIndex,1);
		}
	}
});
$(function(){
	/* 批量删除*/
	$('#del-user-btn').click(function () {
		batchDel();
	});
	/* Modal提交*/
	$('.user-modal-submit').click(function () {
	    if (userModalSubmitType == 1) {
	        addUser();
	    } else {
	        updateUser();
	    }
	});
	
	$('#user-modal').on('show.bs.modal', function (event) {
		let btn = $(event.relatedTarget);
		let index = btn.data("id"); 
		if(index != -1) {
			let userInfo = resultCache[index];
			currentUpdateUser = userInfo;
			openUserModal(userInfo, 2);
		}else {
			openUserModal(null, 1);
		}
	});
	
});
/* 修改*/
/*$(document).on('click', '.update-user', function () {
	let divIndex = $($($($(this).parent()).parent())).parent().index();
    let userInfo = resultCache[divIndex];
    currentUpdateUser = userInfo;
    openUserModal(userInfo, 2);
});*/
/* 停用*/
$(document).on('click', '.lock-user', function () {
	let index = $(this).data('id');
    let userInfo = resultCache[index];
    if (userInfo.locked == 0) {
        userInfo.locked = 1;
        confirmModal('lockUser', '是否停用', userInfo);
    } else {
        userInfo.locked = 0;
        confirmModal('lockUser', '是否启用', userInfo);
    }
});

$(document).on('click', '.delete-user', function () {
	let userId = $(this).data('id');
    let ids = {
    	ids:[userId]
    }
    confirmModal('deleteUser', '是否删除', ids);
});




