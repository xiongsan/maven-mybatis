define(["base","datatables.net","enclosure"],function(base,DataTable){
    var grid1date = null;
function setTable(){
            var grid1Option ={
                "searching":false,
                "lengthChange":true,
                "autoWidth":false,
                "serverSide":true,
                "paging":true,
                "stateSave":true,
                "ordering":false,
                "lengthMenu":[22],
                "language":{"url":$.base+"/js/lib/chinese.json"},
                "ajax":{
                    "type":"post",
                    "url":sweets.getPageUrl(),
                    contentType:'application/json;charset=UTF-8',
                    "data": function ( d ) {
                        d.start =!d.start?d.start:d.start+2;
                        d.length = 20;
                        var params={
                            serviceId:'fileServiceImpl',
                            method:'getFileList',
                                param:{
                                    pageNo: d.start/d.length+1,
                                    pageSize: d.length,
                                    fileName:$("#searchApprovalMessage").val(),//申请方
                                }
                        };
                        return JSON.stringify(params);
                    }
                },
                "columns":[
                    {"title":"序号","data":"id","sWidth":"4%"},
                    {"title":"文件地址", "data":"fileUrl","sWidth":"24%"},
                    {"title":"文件名称", "data":"fileName","sWidth":"24%"},
                    {"title":"创建时间", "data":"createTime","sWidth":"24%"},
                    {"title":"操作", "data":"operate","sWidth":"24%"}
                ],
                "columnDefs":[
                    {
                        "render":function(data,type,row,meta){
                            return meta.row+1+meta.settings._iDisplayStart;
                        },
                        "targets":0
                    },
                    {
                        "render":function(data,type,row,meta){
                            var html="";
                            html="<span class='widthLength widthLengthEx' style='width:100%;text-align: center' title='"+data+"'>"+data+"</span>";
                            return html;
                        },
                        "targets":1
                    },
                    {
                        "render":function(data,type,row,meta){
                            var html="";
                            html="<span class='widthLength' title='"+data+"' style='width:100%;text-align: center'>"+row.fileName+"</span>";
                            return html;
                        },
                        "targets":2
                    },
                    {
                        "render":function(data,type,row,meta){
                            if(data != null && data != ''){
                                return (new Date(data)).format("YYYY-MM-DD HH:mm:SS");
                            }
                        },
                        "targets":3
                    },
                    {"render":function(data,type,row,meta){

                        html1 =  "<div class='clearfix'>" +
                            "<div style='display:inline-block;'><button class='btn btn-link delete' rowId='"+row.fileUrl+"'>删除</button></div>&nbsp;&nbsp;&nbsp;&nbsp;";
                        html2 =  `<a href='${sweets.download(row.fileName,row.fileUrl)}'>下载</a>`;
                        return html1+html2;
                    },
                        "targets":4
                    }
                ],

                "drawCallback":function(setting){
                    $("#tblLiveApproval_length").hide();
                    $(".delete").off().on("click",function(){
                        var fileUrl=$(this).attr("rowId")
                        sweets.startService({serviceId:'fileServiceImpl',method:'deleteFile',param:{fileUrl}}).then(function (e) {
                            if(e.status==='1'){
                                grid1date.ajax.reload()
                            }
                            else{
                                alert(e.tips)
                            }
                        })
                    });
                }
            }
                 grid1date= $("#tblLiveApproval").DataTable(grid1Option);
	    };

	    function setPage(){
			//时间插件
			 base.form.date({
				 element:$(".date"),
				 isTime:true,
				 theme:"#00479d",
				 dateOption:{ 
					// min:getNowFormatDate(),
					 max: "2099-06-16 23:59", //最大日期
					 format: 'yyyy-MM-dd HH:mm'
				 }
			 });

            //依据直播名称查询
            $(".fuzzySearchBtn").on("click",function(){
                grid1date.ajax.reload();
            });

        };

		return {
			run:function(){
				setTable();
				setPage();
			}
		};
});
