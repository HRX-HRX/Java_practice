function getParamValue(keyurl) {
    var param = location.search;//拿到 ?k1=value1&k2=value2
    param=param.substring(1);//去掉问号
    var paramArr=param.split("&");//以 & 符号分隔
    for(var i=0;i<paramArr.length;i++){
        var item = paramArr[i].split("=");
        if(item[0] == keyurl){
            return item[1];
        }
    }
    return null;
}
