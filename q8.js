var num = 2;

function level1(){

    var num1 = 6;

    console.log(num + num1);
    function level2(){
 
        var num2 = 9;
        console.log(num + num1 + num2);
        function level3(){

            var num3 = 7;
            console.log(num + num1 + num2 + num3);
        }

        level3();
    }

    level2();
}
level1();