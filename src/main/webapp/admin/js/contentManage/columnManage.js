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
		this.id;
		this.name;
		this.rename;
		this.parentId;
		this.img;
		this.channel;
		this.level;
		this.type;
		this.path
		this.sort;
		this.isShow;
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

class OperationColumn {
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

class QueryRootColumn {
	static query() {
		return new Promise((resolve) => {
			$.ajax({
				url: 'admin/columnManage/getRootColumnList',
				type: 'GET',
				async: true,
				contentType: "application/json; charset=utf-8",
	            dataType: 'json'
			}).then((result) => {
				resolve(result)
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
						<input type="checkbox" class="ace checkbox-column" data-id="${result[i].id}"/> <span class="lbl"></span>
				</label></td>

				<td>${result[i].name}</td>
				<td>${result[i].rename}</td>
				<td>${getChannel(result[i].channel)}</td>
				<td>${result[i].sort}</td>
				<td>${result[i].createTime}</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
						<button class="btn btn-minier btn-primary update-column" data-toggle="modal" data-id="${i}" data-target="#column-modal">修改</button>
						<button class="btn btn-minier btn-danger delete-column" data-id="${result[i].id}">删除</button>
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

function queryRootColumn() {
	QueryRootColumn.query().then((result) => {
		console.log(result.dataList)
		let rootCoulumList = result.dataList;
		if(rootCoulumList.length > 0) {
			let optionValue = '';
			for (let i = 0; i < rootCoulumList.length; i++) {
	        	
				optionValue +=
	        	`<option value="${rootCoulumList[i].id}">${rootCoulumList[i].name}</option>`;
	        }
	        $('#root-column-select').append(optionValue);
		}
	});
}

function doOperation(columnInfo, type) {
    $('#column-modal').modal('hide');
    $("#file-selector").fileinput('clear');
    $('.loading-word').html('正在提交...')
    $('.submit-loading').css('display', 'block');
    OperationColumn.operation(JSON.stringify(columnInfo), type).then((result) => {
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
		doOperation(ids, 'deleteColumn');
	} else {
		alert("请先勾选！");
	}
	
}

function addColumn() {
    let column = new Column();//
    column.name = $('#name').val().replace(/(^\s*)|(\s*$)/g, "");
    column.rename = $('#rename').val().replace(/(^\s*)|(\s*$)/g, "");
    column.path = $('#path').val().replace(/(^\s*)|(\s*$)/g, "");
    if(null != isUploaded) {
    	column.img = isUploaded.response.data.path;
    }
    column.level = $("input[name='level']:checked").val();
    column.type = $('#type-select option:selected').val();
    column.channel = $("input[name='channel']:checked").val();
    column.isShow = $("input[name='isShow']:checked").val();
    column.parentId =  $('#root-column-select option:selected').val();
    column.sort = $('#sort').val();
    if (column.name != '' && column.path != '' && column.level != '' && column.channel != '' && column.parentId != '') {
    	doOperation(column, 'addColumn', '添加');
    } else {
        alert('信息未输入完整');
    }
}

function updateColumn() {//currentUpdateUser
    let column = new Column();
    column.id = currentUpdateColumn.id;
    column.name = $('#name').val().replace(/(^\s*)|(\s*$)/g, "");
    column.rename = $('#rename').val().replace(/(^\s*)|(\s*$)/g, "");
    column.path = $('#path').val().replace(/(^\s*)|(\s*$)/g, "");
    if(null != isUploaded) {
    	column.img = isUploaded.response.data.path;
    }else {
    	column.img = currentUpdateColumn.img;
    }
    column.level = $("input[name='level']:checked").val();
    column.type = $('#type-select option:selected').val();
    column.channel = $("input[name='channel']:checked").val();
    column.isShow = $("input[name='isShow']:checked").val();
    column.parentId =  $('#root-column-select option:selected').val();
    column.sort = $('#sort').val();
    doOperation(column, 'updateColumn', '修改');
}

function confirmModal(type, content, data) {
	$('#modal-alert-content').html(content);
    $('#confirm-modal').modal('show');
    $('#confirm-modal-submit').unbind("click");
    $('#confirm-modal-submit').click(function () {
        $('#confirm-modal').modal('hide');
        switch (type) {
            case 'deleteColumn':
                doOperation(data, 'deleteColumn');
                break;
            default:
                break;
        }
        $('#confirm-modal-submit').unbind("click");
    });
}

function openColumnModal(columnInfo, type) {
    if (type == 1) {
        $('#column-modal-title').html('新增栏目');
        $('#name').val('');
        $('#rename').val('');
        $('#path').val('');
        $('#sort').val('');
        $('.column-modal-submit').html('确认添加');
        $("#preview-img").hide();
        columnModalSubmitType = 1;
    } else {
        $('#column-modal-title').html('修改信息');
        $('#name').val(columnInfo.name);
        $('#rename').val(columnInfo.rename);
        if(columnInfo.img) {
        	$("#column-img").attr('src',columnInfo.img); 
        }
        $('#path').val(columnInfo.path);
        $('#username').attr('disabled', 'disabled');
        if (columnInfo.channel == 0) {
        	$("input:radio[name='channel'][value=0]").attr('checked','true');
        } else {
        	$("input:radio[name='channel'][value=1]").attr('checked','true');
        }
        if (columnInfo.level == 0) {
        	$("input:radio[name='level'][value=0]").attr('checked','true');
        } else {
        	$("input:radio[name='level'][value=1]").attr('checked','true');
        }
        if (columnInfo.isShow == 0) {
        	$("input:radio[name='isShow'][value=0]").attr('checked','true');
        } else {
        	$("input:radio[name='isShow'][value=1]").attr('checked','true');
        }
        $('#sort').val(columnInfo.sort);
        $('.column-modal-submit').html('确认修改');
        $("#preview-img").show();
        columnModalSubmitType = 2;
    }
}
/* 单个删除*/
$(document).on('click', '.delete-column', function () {
	let columnId = $(this).data('id');
	let ids = {
			ids:[columnId]
	};
	confirmModal('deleteColumn', '是否删除', ids);
});
/* 选择框 */
$(document).on('change', '.checkbox-column', function () {
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
	$('.checkbox-column-all').change(function() { 
		if($(this).is(':checked')) {
			$('.checkbox-column').each(function() {
				$(this).prop('checked', true);
			});
		} else {
			$('.checkbox-column').each(function() {
				$(this).prop('checked', false);
			});
		}
		$('.checkbox-column').each(function() {
			$(this).change();
		});
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
		queryRootColumn();
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
	
	$(".column-img-remove").click(function () {
		currentUpdateColumn.img = '';
		$("#column-img").attr('src',''); 
		$("#preview-img").hide();
	});
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
