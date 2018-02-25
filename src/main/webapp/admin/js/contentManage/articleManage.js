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
class Article {
	constructor() {
		this.name;
		this.rename;
		this.channel;
		this.sort;
		this.createTime;
	}
}

let param = new QueryParam();

let article = new Article();
/**缓存结果集*/
let resultCache;
let currentUpdateArticle;
let selectedArr = new Array();
let articleModalSubmitType;

class QueryArticle {
	static query(data) {
		return new Promise((resolve) => {
			$.ajax({
				url: 'admin/articleManage/getArticleList',
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

class OperationArticle {
	static operation(data, type) {
		let url = "admin/articleManage/" + type;
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
		function getRecommend(val) {
            if (val == 2) {
                return '是';
            } else {
                return '否';
            }
        }
		
		function getTop(val) {
            if (val == 1) {
                return '是';
            } else {
                return '否';
            }
        }
		for (let i = 0; i < result.length; i++) {
        	
        	htmlValue +=
        	`<tr>
				<td class="center"><label class="position-relative">
						<input type="checkbox" class="ace checkbox-user" data-id="${result[i].id}"/> <span class="lbl"></span>
				</label></td>
        		<td>${result[i].title}</td>
				<td>${getRecommend(result[i].topType)}</td>
				<td>${getTop(result[i].topType)}</td>
				<td>${result[i].viewCount}</td>
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
	QueryArticle.query(data).then((result) => {
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

function addArticle() {
    let article = new Article();//
    article.name = $('#name').val().replace(/(^\s*)|(\s*$)/g, "");
    article.rename = $('#rename').val().replace(/(^\s*)|(\s*$)/g, "");
    article.path = $('#path').val().replace(/(^\s*)|(\s*$)/g, "");
    article.img = $('#img').val().replace(/(^\s*)|(\s*$)/g, "");
    article.level = $("input[name='sex']:checked").val();
    article.channel = $("input[name='channel']:checked").val();
    article.parentId =  $('#parentId').val()
    article.sort = $('#sort').val()
    if (article.name != '' && article.path != '' && article.level != '' && article.channel != '' && article.parentId != '') {
    	doOperation(column, 'addColumn', '添加');
    } else {
        alert('信息未输入完整');
    }
}

function updateArticle() {//currentUpdateUser
    let article = currentUpdateArticle;
    article.name = $('#name').val().replace(/(^\s*)|(\s*$)/g, "");
    article.rename = $('#rename').val().replace(/(^\s*)|(\s*$)/g, "");
    article.path = $('#path').val().replace(/(^\s*)|(\s*$)/g, "");
    article.img = $('#img').val().replace(/(^\s*)|(\s*$)/g, "");
    article.level = $("input[name='sex']:checked").val();
    article.channel = $("input[name='channel']:checked").val();
    article.parentId =  $('#parentId').val()
    article.sort = $('#sort').val()
    doOperation(article, 'updateArticle', '修改');
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
function openUserModal(columnInfo, type) {
    if (type == 1) {
        $('#article-modal-title').html('新增新闻');
        $('#name').val('');
        $('#rename').val('');
        $('#path').val('');
        $('#img').html('&nbsp;');
        $('#password').css('display', '');
        $('#username-input').removeAttr('disabled');
        $('.article-modal-submit').html('确认添加');
        columnModalSubmitType = 1;
    } else {
        $('#article-modal-title').html('修改信息');
        $('#name').val(columnInfo.name);
        $('#rename').val(columnInfo.rename);
        $('#path').val(columnInfo.path);
        $('#username').attr('disabled', 'disabled');
        if (columnInfo.sex == 0) {
        	$("input:radio[value=0]").attr('checked','true');
        } else {
        	$("input:radio[value=1]").attr('checked','true');
        }
        $('.article-modal-submit').html('确认修改');
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
	/* 批量删除*/
	$('#del-article-btn').click(function () {
		batchDel();
	});
	/* Modal提交*/
	$('.article-modal-submit').click(function () {
	    if (columnModalSubmitType == 1) {
	        addColumn();
	    } else {
	        updateColumn();
	    }
	});
	
	$('#article-modal').on('show.bs.modal', function (event) {
		let btn = $(event.relatedTarget);
		let index = btn.data("id"); 
		if(index != -1) {
			let columnInfo = resultCache[index];
			currentUpdateColumn = columnInfo;
			openArticleModal(columnInfo, 2);
		}else {
			openArticleModal(null, 1);
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
});
