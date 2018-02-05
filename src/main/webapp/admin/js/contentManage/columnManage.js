/**
 * 
 */
let treeCache;

class QueryParam {
	constructor() {
		this.columnId;
		this.columnName;
		this.pageSize = 10;
		this.pageNum = 1;
	}
}
class Column {
	constructor() {
		this.name;
		this.rename;
		this.channel;
		this.sort;
		this.createTime;
	}
}

let param = new QueryParam();

let column = new Column();
/**缓存结果集*/
let resultCache;
let currentUpdateColumn;
let selectedArr = new Array();
let columnModalSubmitType;

class QueryColumn {
	static query(data) {
		return new Promise((resolve) => {
			$.ajax({
				url: 'admin/columnManage/getColumnList',
				type: 'POST',
				async: true,
				contentType: "application/json; charset=utf-8",
	            data: JSON.stringify(data),
	            dataType: 'json'
			}).then((result) => {
				resolve(result)
			});
		});
	}
}

class OperationUser {
	static operation(data, type) {
		let url = "admin/columnManage/" + type;
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
		let htmlValue = '';
		function getChannel(val) {
            if (val == 0) {
                return '中文版';
            } else {
                return '英文版';
            }
        }
		for (let i = 0; i < result.length; i++) {
        	
        	htmlValue +=
        	`<tr>
				<td class="center"><label class="position-relative">
						<input type="checkbox" class="ace checkbox-user" data-id="${result[i].id}"/> <span class="lbl"></span>
				</label></td>

				<td>${result[i].name}</td>
				<td>${result[i].rename}</td>
				<td>${getChannel(result[i].channel)}</td>
				<td>${result[i].sort}</td>
				<td>${result[i].createTime}</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
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
	$('#table-tbody').html('');
	$('.loading').css('display', 'block');
	QueryColumn.query(data).then((result) => {
		$('.loading').css('display', 'none');
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

function queryDefault() {
	param.pageNum = 1;
	query(param);
}

queryDefault();

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

function addColumn() {
    let column = new Column();//
    column.name = $('#name').val().replace(/(^\s*)|(\s*$)/g, "");
    column.rename = $('#rename').val().replace(/(^\s*)|(\s*$)/g, "");
    column.path = $('#path').val().replace(/(^\s*)|(\s*$)/g, "");
    column.img = $('#img').val().replace(/(^\s*)|(\s*$)/g, "");
    column.level = $("input[name='sex']:checked").val();
    column.channel = $("input[name='channel']:checked").val();
    column.parentId =  $('#parentId').val()
    column.sort = $('#sort').val()
    if (column.name != '' && column.path != '' && column.level != '' && column.channel != '' && column.parentId != '') {
    	doOperation(column, 'addColumn', '添加');
    } else {
        alert('信息未输入完整');
    }
}

function updateColumn() {//currentUpdateUser
    let column = currentUpdateColumn;
    column.name = $('#name').val().replace(/(^\s*)|(\s*$)/g, "");
    column.rename = $('#rename').val().replace(/(^\s*)|(\s*$)/g, "");
    column.path = $('#path').val().replace(/(^\s*)|(\s*$)/g, "");
    column.img = $('#img').val().replace(/(^\s*)|(\s*$)/g, "");
    column.level = $("input[name='sex']:checked").val();
    column.channel = $("input[name='channel']:checked").val();
    column.parentId =  $('#parentId').val()
    column.sort = $('#sort').val()
    doOperation(column, 'updateColumn', '修改');
}

function confirmModal(type, content, data) {
	$('#modal-alert-content').html(content);
    $('#confirm-modal').modal('show');
    $('#confirm-modal-submit').unbind("click");
    $('#confirm-modal-submit').click(function () {
        $('#confirm-modal').modal('hide');
        switch (type) {
            case 'deleteUser':
                doOperation(data, 'deleteColumn');
                break;
            case 'lockUser':
            	doOperation(data, 'updateColumn');
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
function openColumnModal(columnInfo, type) {
    if (type == 1) {
        $('#column-modal-title').html('新增栏目');
        $('#name').val('');
        $('#rename').val('');
        $('#path').val('');
        $('#sort').val('');
        $('.column-modal-submit').html('确认添加');
        columnModalSubmitType = 1;
    } else {
        $('#column-modal-title').html('修改信息');
        $('#name').val(columnInfo.name);
        $('#rename').val(columnInfo.rename);
        $('#path').val(columnInfo.path);
        $('#username').attr('disabled', 'disabled');
        if (columnInfo.sex == 0) {
        	$("input:radio[value=0]").attr('checked','true');
        } else {
        	$("input:radio[value=1]").attr('checked','true');
        }
        $('.column-modal-submit').html('确认修改');
        columnModalSubmitType = 2;
    }
}

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
	QueryTree.getColumnTree().then((result) => {
		treeCache = result;
		$('#tree').treeview({
	   		data: treeCache,
	   		onNodeSelected: function(event, node) {
	   			console.log("id:" + node.id + "text:" + node.text + 'was selected');
	   		}
	   	});
		$('#tree').treeview('collapseAll', { silent: true });
	});
	/* 批量删除*/
	$('#del-column-btn').click(function () {
		batchDel();
	});
	/* Modal提交*/
	$('.column-modal-submit').click(function () {
	    if (columnModalSubmitType == 1) {
	        addColumn();
	    } else {
	        updateColumn();
	    }
	});
	
	$('#column-modal').on('show.bs.modal', function (event) {
		let btn = $(event.relatedTarget);
		let index = btn.data("id"); 
		if(index != -1) {
			let columnInfo = resultCache[index];
			currentUpdateColumn = columnInfo;
			openColumnModal(columnInfo, 2);
		}else {
			openColumnModal(null, 1);
		}
	});
	
});

$(document).on('click', '.delete-column', function () {
	let columnId = $(this).data('id');
    let ids = {
    	ids:[columnId]
    }
    confirmModal('deleteColumn', '是否删除', ids);
});

class QueryTree {
	static getColumnTree() {
		return new Promise((resolve) => {
			$.ajax({
	            url: 'admin/columnManage/getColumnTree',
	            type: 'GET',
	            async: true,
	            contentType: "application/json; charset=utf-8",
	            dataType: 'json'
	        }).then((result) => {
	            resolve(result);
	        });
		});
	}
}
