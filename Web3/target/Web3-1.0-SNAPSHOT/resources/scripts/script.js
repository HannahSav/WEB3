function XYR(){
    x = $("input[name='form:slider_x_hidden']").val();
    y = $("input[name='form:y_in']").val();
    r = $("input[id='form:slider_r_hidden']").val()/10;
}

function checkY(y) {
    if (!y) {
        return exceptionY('<br>Вы не ввели Y</br>')
    } else if (isNaN(y)) {
        return exceptionY('<br>Y должен быть числом</br>')
    } else if (y < -5 || y > 5) {
        return exceptionY('<br>Y не принадлежит [-5:5]</br>')
    } else {
        $(".exceptionY").html('');
        return true
    }
}

function exceptionY(message) {
    $(".exceptionY").html(message);
    point(0,0, 2.5);
    return false
}

$(function () {
    // $('#send').on('click', function (event) {
    // XYR();
    // if(checkY(x, y, r)) {
    //     $.get(
    //     "/CheckArea",
    //     {x: x, y: y, r: r}
    //     )
    //     // drawPoints(x, y, r)
    // } else {
    //     event.preventDefault()
    //     }
    // });

});

function change() {
    setTimeout(function(){
        XYR();
        if (checkY(y))
            point(x, y, r);
    }, 150);

}


function point(x, y, r) {
    $('#point').attr("cx", (x * 120 / r + 200))
        .attr("cy", (y * -120 / r + 200));
}

