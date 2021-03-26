function convertCurrency() {
    let amountC = document.getElementById("amount");
    let fromC = document.getElementById("from");
    let toC = document.getElementById("to");
    let currency;
    if (fromC.value == 'VND' && toC.value == 'USD'){
        currency = amountC.value/23000;
    }else if (fromC.value == 'USD' && toC.value == 'VND'){
        currency = amountC.value*23000;
    }else {
        currency = "đơn vị tiền không thể trùng nhau,vui lòng thử lại!";
    }
    document.getElementById("result").innerHTML = "Result : "+currency;
}