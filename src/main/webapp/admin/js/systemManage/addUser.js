/**
 * 
 */
/*  提交按钮*/
$('#add-user-submit').click(function () {
    let remark = $('#video-remark').val();
    if (isUploaded == null) {
        alert('请上传视频');
    } else if (remark == '') {
        alert('请输入视频描述');
    } else {
        class UserAddVo {
            constructor() {
                this.fileName = isUploaded.files[0].name;
                this.remark = remark;
                this.filePath = isUploaded.jqXHR.responseJSON.data.path;
                this.createTime = new Date();
            }
        }
        let data = new UserAddVo();
        console.log(data);
        $('.upload-video-btn').attr('disabled', 'disabled');
        $('#upload-video').modal('hide');
        $('.loading-word').html('正在提交...')
        $('.submit-loading').css('display', 'block');
        $.ajax({
            url: '../commandManage/classicCase/addClassicCase',
            type: 'POST',
            async: true,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result);
                if (result.retcode == 1) {
                    $('.loading-gif').attr('src', '../img/submit_success.png');
                    $('.loading-word').html('<span style="color: rgb(10, 180, 0)">提交成功</span>');
                } else {
                    $('.loading-gif').attr('src', '../img/submit_fail.png');
                    $('.loading-word').html('<span style="color: rgb(255, 120, 120);">提交失败</span>');
                }
                setTimeout(function () {
                    $('.submit-loading').fadeOut(600);
                    $('.upload-video-btn').removeAttr('disabled');
                    queryDefault();
                }, 2000);
            }
        });
    }
});