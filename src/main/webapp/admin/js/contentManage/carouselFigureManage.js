/**
 * 轮播图管理
 */
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

function QueryParam() {
	this.title;
	this.pageSize = 10;
	this.pageNum = 1;
}

function CarouselFigure() {
	this.id,
	this.title;
	this.imgPath;
	this.href;
	this.sort;
}

let param = new QueryParam();
let carouselFigure = new CarouselFigure();
/**缓存结果集*/
let resultCache;
let currentUpdateCarouselFigure;
let selectedArr = new Array();
let modalSubmitType;
function operation(data, type) {
	let url = "admin/carouselFigureManage/" + type;
	 $.ajax({
         url: url,
         type: 'POST',
         async: true,
         contentType: "application/json; charset=utf-8",
         data: data,
         dataType: 'json',
         success: function(result) {
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
         }
     });
}

function fillData(result) {
    let htmlValue = '';
    for (let i = 0; i < result.length; i++) {
    	
    	htmlValue +=
    	'<tr>'
			+'<td class="center"><label class="position-relative">'
			+		'<input type="checkbox" class="ace checkbox-carouselFigure" data-id="'+result[i].id+'"/> <span class="lbl"></span>'
			+'</label></td>'
			+'<td>'+result[i].title+'</td>'
			+'<td><img src="'+result[i].imgPath+'" width="338px" height="128px"></td>'
			+'<td>'+result[i].href+'</td>'
			+'<td>'+result[i].sort+'</td>'
			+'<td>'+result[i].createTime+'</td>'
			+'<td>'+result[i].updateTime+'</td>'
			+'<td>'
			+	'<div class="hidden-sm hidden-xs action-buttons">'
			+		'<button class="btn btn-minier btn-primary update-carouselFigure" data-toggle="modal" data-id="'+i+'" data-target="#carouselFigure-modal">修改</button>'
			+		'<button class="btn btn-minier btn-danger delete-carouselFigure" data-id="'+result[i].id+'">删除</button>'
			+	'</div>'
			+'</td>'
		+'</tr>';
    }
    $('#table-tbody').append(htmlValue);
}

function drawPage(result) {
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

function query(data) {
	$('#table-tbody').html('');
	$('.loading').css('display', 'block');
	$.ajax({
        url: 'admin/carouselFigureManage/getCarouselFigureList',
        type: 'POST',
        async: true,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        dataType: 'json',
        success: function(result) {
        	$('.loading').css('display', 'none');
        	console.log(result.pageInfo);
        	selectedArr = new Array();
        	if (result.pageInfo.list.length > 0) {
            	resultCache = result.pageInfo.list;
            	fillData(resultCache);
            	drawPage(result);
            	$('#total-count').html(result.pageInfo.total);
            }
        }
    });
}



queryDefault();
function queryDefault() {
	param.pageNum = 1;
	query(param);
}

function doOperation(carouselFigureInfo, type) {
    $('#carouselFigure-modal').modal('hide');
    $("#file-selector").fileinput('clear');
    $('.loading-word').html('正在提交...')
    $('.submit-loading').css('display', 'block');
    operation(JSON.stringify(carouselFigureInfo), type)
}

function onSearch() {
	param.pageNum = 1;
	param.title = $('#titleSearch').val();
	query(param);
}

function batchDel() {
	let ids = {ids:[]}
	if(selectedArr.length > 0){
		ids.ids = selectedArr;
		doOperation(ids, 'deleteCarouselFigure');
	} else {
		alert("请先勾选！");
	}
	
}

function addCarouselFigure() {
    let carouselFigure = new CarouselFigure();//
    carouselFigure.title = $('#title').val().replace(/(^\s*)|(\s*$)/g, "");
    if(null != isUploaded) {
    	carouselFigure.imgPath = isUploaded.response.data.path;
    }
    carouselFigure.href = $('#href').val().replace(/(^\s*)|(\s*$)/g, "");
    carouselFigure.sort = $('#sort').val();
    if (carouselFigure.title != '' && carouselFigure.imgPath != '' && carouselFigure.href != '') {
    	doOperation(carouselFigure, 'addCarouselFigure', '添加');
    } else {
        alert('信息未输入完整');
    }
}

function updateCarouselFigure() {//currentUpdateUser
	let carouselFigure = new CarouselFigure();//
	carouselFigure.id = currentUpdateCarouselFigure.id;
    carouselFigure.title = $('#title').val().replace(/(^\s*)|(\s*$)/g, "");
    if(null != isUploaded) {
    	carouselFigure.imgPath = isUploaded.response.data.path;
    }else {
    	carouselFigure.imgPath = currentUpdateCarouselFigure.imgPath;
    }
    carouselFigure.href = $('#href').val().replace(/(^\s*)|(\s*$)/g, "");
    carouselFigure.sort = $('#sort').val();
    if (carouselFigure.id != '' && carouselFigure.title != '' && carouselFigure.imgPath != '' && carouselFigure.href != '') {
    	doOperation(carouselFigure, 'updateCarouselFigure', '修改');
    } else {
        alert('信息未输入完整');
    }
}

function confirmModal(type, content, data) {
	$('#modal-alert-content').html(content);
    $('#confirm-modal').modal('show');
    $('#confirm-modal-submit').unbind("click");
    $('#confirm-modal-submit').click(function () {
        $('#confirm-modal').modal('hide');
        switch (type) {
            case 'deleteCarouselFigure':
                doOperation(data, 'deleteCarouselFigure');
                break;
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
/* type=1为添加，type=2为修改*/
function openModal(carouselFigure, type) {
    if (type == 1) {
        $('#carouselFigure-modal-title').html('新增轮播图');
        $('#title').val('');
        $('#href').val('');
        $('#sort').html('');
        $('.carouselFigure-modal-submit').html('确认添加');
        $("#preview-img").hide();
        modalSubmitType = 1;
    } else {
        $('#carouselFigure-modal-title').html('修改轮播图');
        $('#title').val(carouselFigure.title);
        if(carouselFigure.imgPath) {
        	$("#img_path").attr('src',carouselFigure.imgPath); 
        }else {
        	$("#img_path").attr('src','upload/images/default_img.jpg'); 
        }
        $('#href').val(carouselFigure.href);
        $('#sort').val(carouselFigure.sort);;
        $('.carouselFigure-modal-submit').html('确认修改');
        $("#preview-img").show();
        modalSubmitType = 2;
    }
}

$(document).on('change', '.checkbox-carouselFigure-all', function(){
	if($(this).is(':checked')) {
		$('.checkbox-carouselFigure').each(function() {
			$(this).prop('checked', true);
		});
	} else {
		$('.checkbox-carouselFigure').each(function() {
			$(this).prop('checked', false);
		});
	}
	$('.checkbox-carouselFigure').each(function() {
		$(this).change();
	});
});
/* 选择框 */
$(document).on('change', '.checkbox-carouselFigure', function () {
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
	$('#del-carouselFigure-btn').click(function () {
		batchDel();
	});
	/* Modal提交*/
	$('.carouselFigure-modal-submit').click(function () {
	    if (modalSubmitType == 1) {
	    	addCarouselFigure();
	    } else {
	        updateCarouselFigure();
	    }
	});
	
	$('#carouselFigure-modal').on('show.bs.modal', function (event) {
		let btn = $(event.relatedTarget);
		let index = btn.data("id"); 
		if(index != -1) {
			let carouselFigureInfo = resultCache[index];
			currentUpdateCarouselFigure= carouselFigureInfo;
			openModal(carouselFigureInfo, 2);
		}else {
			openModal(null, 1);
		}
	});
	$(".column-img-remove").click(function () {
		currentUpdateCarouselFigure.imgPath = '';
		$("#img_path").attr('src',''); 
		$("#preview-img").hide();
	});
});

$(document).on('click', '.delete-carouselFigure', function () {
	let userId = $(this).data('id');
    let ids = {
    	ids:[userId]
    }
    confirmModal('deleteCarouselFigure', '是否删除', ids);
});
