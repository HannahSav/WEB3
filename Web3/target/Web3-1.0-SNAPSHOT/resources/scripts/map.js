let svg = document.getElementById('graph');

function clickGraph() {
    $('.graph').on('click', function click(event) {
        let position = getMousePosition(svg, event);
        let x = position.x;
        let y = position.y;
        let r = $("input[id='rValue']").val();
        let y_val = ((200 - y) * r / 120).toFixed(4);
        if (y_val > 4) y_val = 4;
        if (y_val < -4) y_val = -4;
        let x_val = (((x - 200) * r / 120)).toFixed();
        if (x_val >= 4) x_val = 4;
        if (x_val <= -4) x_val = -4;
        if (x_val === "-0") x_val = 0;
        point1(x_val, y_val, r);
        $("input[name='form:x_in']").val(x_val);
        $("input[name='form:y_in']").val(y_val);
    });
}

function point1(x, y, r) {
    $('#point').attr('cx', x*120/r + 200).attr('cy', 200 - y*120/r );
}

function getMousePosition(svg, event) {
    let rect = svg.getBoundingClientRect();
    return {
        x: event.clientX - rect.left,
        y: event.clientY - rect.top
    };
}

function drawPoints(x, y, r) {
    if (getHit(x, y, r) === true) {
        document.querySelector('.graph').innerHTML += '<circle r="5" cx="' + (x * 1200 / r + 200) +
            '" cy="' + (y * -1200 / r + 200) + '" fill="green" ></circle>'
    } else {
        document.querySelector('.graph').innerHTML += '<circle r="5" cx="' + (x * 1200 / r + 200) +
            '" cy="' + (y * -1200 / r + 200) + '" fill="red" ></circle>'
    }
}

function getHit(x, y, r) {
    if (x <= 0 && y <= 0 && y >= -x - r/2){
        return true
    }
    if (x >= 0 && y <= 0 && x*x + y*y <= r*r/4){
        return true
    }
    return (x <= 0 && y >= 0 && x >= -r/2 && y <= r)
}