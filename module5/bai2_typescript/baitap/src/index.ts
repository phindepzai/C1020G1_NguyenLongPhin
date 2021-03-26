
// happy coding 👻
function httpGet(url: string): Promise<Array<any>> {
    return new Promise((resolve, reject) => {
        const request = new XMLHttpRequest();
        request.open('GET', url);
        request.send();
        request.onload = function () {
            if (this.status === 200) {
                // Success
                resolve(this.response);
            } else {
                // Something went wrong (404 etc.)
                reject(new Error(this.statusText));
            }
        };
        request.onerror = function () {
            reject(new Error('XMLHttpRequest Error: ' + this.statusText));
        };
    })
}

function createTable(arr: Array<any>) {
    let tag = document.getElementById("list");
    console.log(arr);
    let str = '';
    arr.forEach(item => {
        str += '<tr><td>' + item.id + '</td>';
        str += '<td>' + item.name + '</td>';
        str += '<td>' + item.watchers + '</td></tr>';
    })
    if (tag != null) {
        tag.innerHTML = str;
    }
}

function search(key: string) {
    if (key != '') {
        httpGet('https://api.github.com/search/repositories?q=' + key).then(
            function (value) {
                let s = value.toString();
                value = JSON.parse(s);
                // console.log(value)
                createTable(value.items);
            },
            function (reason) {
                console.error('Something went wrong', reason);
            }
        );
    }
}