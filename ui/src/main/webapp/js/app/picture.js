define(["base","enclosure"],function(base){

    function showPic() {

        sweets.startService({serviceId:'fileServiceImpl',method:'showPic'}).then(function (e) {
            if(e.status==='1'){
                var data=e.data
                $.each(data,function (index,item) {
                    var html1;
                    var html2;
                    html1=!index?'<div class="item active" style="width: 100%;height:100%"><img src="'+sweets.showPic(item.fileUrl)+'" alt="'+item.fileName+'"></div>':
                        '<div class="item"><img src="'+sweets.showPic(item.fileUrl)+'" alt="'+item.fileName+'"></div>'
                    $('.carousel-inner').append(html1)
                    html2=!index?'<li data-target="#myCarousel" data-slide-to="'+index+'" class="active"></li>':
                        '<li data-target="#myCarousel" data-slide-to="'+index+'"></li>'
                    $('.carousel-indicators').append(html2)
                    var height=document.body.clientHeight;
                    var width=height*0.75
                    $('img').css({height:height,width:width})
                    $('#myCarousel').css({width:width})
                })
            }
        })
    }
		return {
			run:function(){
				showPic()
			}
		};
});
