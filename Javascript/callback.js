function show(x){
    return x*x;;
}
function add(test){
    let a = 10;
    let result = test(10);
    console.log(result);
}

add(show);