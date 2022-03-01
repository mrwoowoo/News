$(document).ready(function () {
    //获取div区域
    var opt_area = $("#opt_area");
    function initNews() {
        opt_area.load("/util/news", "opr=listHtml"); // load(请求地址，请求参数)
    }
    initNews();
    
    function initTopics() {//获取所以主题数据
        opt_area.load("/util/topics", "opr=listHtml");
    }
    //获取左边的超链接
    var $leftLink = $("#opt_list a");
    //给第四个超链接绑定点击事件
    $leftLink.eq(3).click(initTopics);
})