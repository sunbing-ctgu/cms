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

let column = Column();

class QueryColumn {
	static query(data) {
		return new Promise((resolve) => {
			$.ajax({
				url: '/admin/columnManage/getColumnList',
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
	});
});
