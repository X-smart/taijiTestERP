$(function () {
	var navjson =
	
	$('#nav').tree({
		lines : true,
		data : 
		[
			{
				"id" : 1,
				"text" : "主控制",
				"state" : "closed",
				"url" : null,
				"children" : [
					{	
						"id" : 2,
						"text" : "菜单1",
						"state" : "open",
						"url" : "html11",
					},
					{
						"id" : 3,
						"text" : "菜单2",
						"state" : "open",
						"url" : "html12",
					},
					{
						"id" : 4,
						"text" : "菜单3",
						"state" : "open",
						"url" : "html13",
					}
				]
			}
		],
		onLoadSuccess : function (node, data) {
			if (data) {
				$(data).each(function (index, value) {
					if (this.state == 'closed') {
						$('#nav').tree('expandAll');
					}
				});
			}
		},
		onClick : function (node) {
			if (node.url) {
				if ($('#tabs').tabs('exists', node.text)) {
					$('#tabs').tabs('select', node.text);
				} else {
					$('#tabs').tabs('add', {
						title : node.text,
						iconCls : node.iconCls,
						closable : true,
						href : node.url ,
					});
				}
			}
		}
	});
	
	$('#tabs').tabs({
		fit : true,
		border : false,
	});
	
	
});