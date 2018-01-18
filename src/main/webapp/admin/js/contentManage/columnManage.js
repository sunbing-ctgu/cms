/**
 * 
 */
let treeCache;
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
	   			console.log(node.text + 'was selected');
	   		}
	   	});
	});
});
