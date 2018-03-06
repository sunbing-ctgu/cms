/**
 * 
 */
let isUploaded = null;
/* 加载bootstrap fileinput*/
$("#file-selector").fileinput({
    uploadUrl: "admin/fileUpload/upload",//上传的地址
    language: 'zh',
    showUpload: false,//是否显示上传按钮,跟随文本框的那个
    showRemove: false,//显示移除按钮,跟随文本框的那个
    showPreview: true,//是否显示预览,不写默认为true
    dropZoneEnabled: false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
    //minImageWidth: 50, //图片的最小宽度
    //minImageHeight: 50,//图片的最小高度
    //maxImageWidth: 1000,//图片的最大宽度
    //maxImageHeight: 1000,//图片的最大高度
    //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
    //minFileCount: 0,
    maxFileCount: 1,
    enctype: 'multipart/form-data',
    allowedFileTypes: ['image'],//配置允许文件上传的类型
    allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
    allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
});
/*自动上传*/
$("#file-selector").on("filebatchselected", function(event, files) {
	$("#preview-img").hide();
	$(this).fileinput("upload");
});
/* 文件上传*/
$("#file-selector").on("fileuploaded", function (event, data, previewId, index) {
    isUploaded = data;
    $('.kv-file-remove').click(function() {
    	isUploaded = null;
    })
    $('.file-upload-error').html('');
});
/* 移除文件*/
$('#file-selector').on('filecleared', function (event, id) {
    isUploaded = null;
});

/* 取消上传*/
$('#file-selector').on('fileuploaderror', function (event, id) {
    isUploaded = null;
    $('.kv-upload-progress').css('display', 'none');
});

var ue = UE.getEditor('container');
ue.ready(function() {
	ue.setHeight(480);
});

let treeCache;

class QueryParam {
	constructor() {
		this.columnId;
		this.title;
		this.pageSize = 10;
		this.pageNum = 1;
	}
}
class Article {
	constructor() {
		this.id,
		this.columnId;
		this.title;
		this.titleImg;
		this.author;
		this.summary;
		this.href;
		this.keyWord;
		this.content;
		this.publishTime;
		this.isType;
		this.isRecommend;
		this.sort;
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
            if (val == 1) {
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
						<input type="checkbox" class="ace checkbox-article" data-id="${result[i].id}"/> <span class="lbl"></span>
				</label></td>
        		<td>${result[i].title}</td>
				<td>${getTop(result[i].isTop)}</td>
				<td>${getRecommend(result[i].isRecommend)}</td>
        		<td>${result[i].viewCount}</td>
				<td>${result[i].sort}</td>
				<td>${result[i].createTime}</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
						<button class="btn btn-minier btn-primary view-article" data-toggle="modal" data-id="${i}" data-type="0" data-target="#article-modal">查看</button>
						<button class="btn btn-minier btn-primary update-article" data-toggle="modal" data-id="${i}" data-type="2" data-target="#article-modal">修改</button>
						<button class="btn btn-minier btn-danger delete-article" data-id="${result[i].id}">删除</button>
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

function doOperation(articleInfo, type) {
    $('#article-modal').modal('hide');
    $('.loading-word').html('正在提交...')
    $('.submit-loading').css('display', 'block');
    OperationArticle.operation(JSON.stringify(articleInfo), type).then((result) => {
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
	param.columnId = $('#userNameSearch').val();
	param.title = $('#titleSearch').val();
	query(param);
}

function batchDel() {
	let ids = {ids:[]}
	if(selectedArr.length > 0){
		ids.ids = selectedArr;
		confirmModal('deleteArticle', '是否删除', ids);
		//doOperation(ids, 'deleteArticle');
	} else {
		alert("请先勾选！");
	}
	
}

function addArticle() {
    let article = new Article();//
    article.columnId = $('#columnId').val();
    article.title = $('#title').val().replace(/(^\s*)|(\s*$)/g, "");
    if(isUploaded) {
    	article.titleImg = isUploaded.response.data.path;
    }
    article.author = $('#author').val().replace(/(^\s*)|(\s*$)/g, "");
    article.summary = $('#summary').val().replace(/(^\s*)|(\s*$)/g, "");
    article.href = $('#href').val().replace(/(^\s*)|(\s*$)/g, "");
    article.keyWord =  $('#key-words').val().replace(/(^\s*)|(\s*$)/g, "");
    article.content = ue.getContent();
    article.publishTime = $('#publish-time').val();
    article.isTop = $("input[name='is-top']:checked").val();
    article.isRecommend = $("input[name='is-recommend']:checked").val();
    article.sort = $('#sort').val()
    if (article.columnId != '' && article.title != '') {
    	doOperation(article, 'addArticle', '添加');
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
            case 'deleteArticle':
                doOperation(data, 'deleteArticle');
                break;
            default:
                break;
        }
        $('#confirm-modal-submit').unbind("click");
    });
}

function openArticleModal(articleInfo, type) {
    if (type == 0) {
    	$('#article-modal-title').html('查看新闻');
    	traverseTree(treeCache, articleInfo.columnId);
        $('#columnId').val(articleInfo.columnId);
        $('#title').val(articleInfo.title);
        $('#author').val(articleInfo.author);
        if(articleInfo.titleImg) {
        	$("#title-img").attr('src',articleInfo.titleImg); 
        }else {
        	$("#title-img").attr('src','upload/images/default_img.jpg'); 
        }
        $('#summary').val(articleInfo.summary);
        $('#key-words').val(articleInfo.keyWords);
        $('#href').val(articleInfo.href);
        $('#publish-time').val(articleInfo.publishTime);
        if(articleInfo.isTop == 0) {
        	 $("input:radio[name='is-top'][value=0]").attr('checked','true');
        }else {
        	 $("input:radio[name='is-top'][value=1]").attr('checked','true');
        }
        if(articleInfo.isRecommend == 0) {
        	$("input:radio[name='is-recommend'][value=0]").attr('checked','true');
        }else {
        	$("input:radio[name='is-recommend'][value=1]").attr('checked','true');
        }
        $('#sort').val(articleInfo.sort);
        if(articleInfo.content) {
        	ue.setContent(articleInfo.content, true);
        }
        $('.article-modal-submit').html('关闭');
        setDisabled();
        articleModalSubmitType = 1;
    }else if(type == 1) {
    	 $('#article-modal-title').html('新增新闻');
         $('#columnName').val('');
         $('#columnId').val('');
         $('#title').val('');
         $('#author').val('');
         $('#summary').val('');
         $('#key-words').val('');
         $('#href').val('');
         $('#publish-time').val('');
         $("input:radio[name='is-top'][value=0]").attr('checked','true');
         $("input:radio[name='is-recommend'][value=0]").attr('checked','true');
         $('#sort').val('');
         ue.setContent('', true);
         $('.article-modal-submit').html('确认添加');
         $("#preview-img").hide();
         setEnabled();
         articleModalSubmitType = 1;
    }else {
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
        setEnabled();
        articleModalSubmitType = 2;
    }
}
function setDisabled() {
	$('#columnName').attr("disabled", true);
    $('#title').attr("disabled", true);
    $('#author').attr("disabled", true);
    $('#summary').attr("disabled", true);
    $('#key-words').attr("disabled", true);
    $('#href').attr("disabled", true);
    $('#publish-time').attr("disabled", true);
    $("input:radio[name='is-top']").attr("disabled", true);
    $("input:radio[name='is-recommend']").attr("disabled", true);
    $('#sort').attr("disabled", true);
}
function setEnabled() {
	$('#columnName').attr("disabled", false);
    $('#title').attr("disabled", false);
    $('#author').attr("disabled", false);
    $('#summary').attr("disabled", false);
    $('#key-words').attr("disabled", false);
    $('#href').attr("disabled", false);
    $('#publish-time').attr("disabled", false);
    $("input:radio[name='is-top']").attr("disabled", false);
    $("input:radio[name='is-recommend']").attr("disabled", false);
    $('#sort').attr("disabled", false);
}
/* 单个删除*/
$(document).on('click', '.delete-article', function () {
	let articleId = $(this).data('id');
    let ids = {
    	ids:[articleId]
    }
    confirmModal('deleteArticle', '是否删除', ids);
});
/* 选择框 */
$(document).on('change', '.checkbox-article', function () {
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
	/* 选择每页显示数量*/
	$('#total-count-selector').change(function () {
	    param.pageNum = 1;
	    param.pageSize = $(this).val();
	    query(param);
	});
	$('.checkbox-article-all').change(function() { 
		if($(this).is(':checked')) {
			$('.checkbox-article').each(function() {
				$(this).prop('checked', true);
			});
		} else {
			$('.checkbox-article').each(function() {
				$(this).prop('checked', false);
			});
		}
		$('.checkbox-article').each(function() {
			$(this).change();
		});
	});
	/* 批量删除*/
	$('#del-article-btn').click(function () {
		batchDel();
	});
	/* Modal提交*/
	$('.article-modal-submit').click(function () {
	    if (articleModalSubmitType == 1) {
	        addArticle();
	    } else {
	        updateArticle();
	    }
	});
	
	$('#article-modal').on('show.bs.modal', function (event) {
		let btn = $(event.relatedTarget);
		let index = btn.data("id"); 
		let type = btn.data("type"); 
		if(index != -1) {
			let articleInfo = resultCache[index];
			currentUpdateArticle = articleInfo;
			openArticleModal(articleInfo, type);
		}else {
			openArticleModal(null, 1);
		}
	});
	
	$("#columnName").click(function() {
		QueryTree.getColumnTree().then((result) => {
			$('#columnTreeView').treeview({
		   		data: result,
		   		onNodeSelected: function(event, node) {
		   			console.log("id:" + node.id + "text:" + node.text + 'was selected');
		   			$("#columnName").val(node.text);
		   			$("#columnId").val(node.id);
		   			$('#columnTreeView').hide();
		   		}
		   	});
			$('#columnTreeView').treeview('collapseAll', { silent: true });
			$("#columnTreeView>ul").css("margin-left", "0px");
		});
	})/*.blur(function() {
		$('#columnTreeView').hide();
	})*/;
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

function traverseTree(nodes, id) {
	if(!nodes) {
		return;
	}
	let i = 0;
	for(i = 0; i < nodes.length; i++) {
		let currentNode = nodes[i];
		if(currentNode.id == id) {
   		 $('#columnName').val(currentNode.text);
   		 return;
        }
		if (currentNode.nodes && currentNode.nodes.length > 0) {
			this.traverseTree(currentNode.nodes, id);
	    }
	}
}
