/**
 * 用户管理
 */
class UserVo {
	constructor() {
		this.pageSize = 10;
		this.pageNum = 1;
	}
}
let userVoCache = new UserVo();

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

class DrawTable {
	static fillData(result) {
		$('#table-tbody').html('');
		let tableContent = result.pageInfo.list;
        console.log(tableContent);
        let htmlValue = '';
        for (let i = 0; i < tableContent.length; i++) {
        	
        	htmlValue +=
        	`<tr>
				<td class="center"><label class="position-relative">
						<input type="checkbox" class="ace" /> <span class="lbl"></span>
				</label></td>

				<td>${tableContent[i].username}</td>
				<td>${tableContent[i].realname}</td>
				<td>${tableContent[i].sex}</td>
				<td>${tableContent[i].tel}</td>
				<td>${tableContent[i].locked}</td>
				<td>${tableContent[i].status}</td>
				<td>
					<div class="hidden-sm hidden-xs action-buttons">
						<button class="btn btn-minier btn-yellow">停用</button>
						<button class="btn btn-minier btn-primary">修改</button>
						<button class="btn btn-minier btn-danger">删除</button>
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
            	userVoCache.pageNum = page;
                QueryUser.query(userVoCache).then((result) => {
                    DrawTable.fillData(result);
                });
            }
        }
        $('#page').bootstrapPaginator(options);
    }

}

function query(data) {
	QueryUser.query(data).then((result) => {
        console.log(result.pageInfo);
        if (result.pageInfo.list.length > 0) {
        	DrawTable.fillData(result);
        	PageInfo.drawPageController(result);
        	$('#total-count').html(result.pageInfo.total);
        } else {

        }
    });
}
queryDefault();
function queryDefault() {
	userVoCache.pageNum = 1;
	query(userVoCache);
}

/* 选择每页显示数量*/
$(function(){
	$('#total-count-selector').change(function () {
	    userVoCache.pageNum = 1;
	    userVoCache.pageSize = $(this).val();
	    query(userVoCache);
	});
});


