$(function(){
    $('nav ul li').hover(
        function () {
            //show its submenu

            $('ul', this).slideDown(150);

        },
        function () {
            //hide its submenu
            $('ul', this).slideUp(150);
        }
    );
});