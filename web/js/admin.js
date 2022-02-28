$(document).ready(function () {
    //获取div区域
    var opt_area = $("#opt_area");
    function initNews() {
        opt_area.load("/util/news", "opr=listHtml"); // load(请求地址，请求参数)
    }
    initNews();
})