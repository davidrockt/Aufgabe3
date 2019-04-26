var http = new XMLHttpRequest();

  function sendRequestGET(path = '', query = '') {
    console.log('path and query: ' + path + query);
    http.open('GET', path + '?' + query);
    http.send();
  }

  http.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById('display').value = this.responseText;
    }
  }

  function sendNumber(value = '') {
      // let currency = document.getElementById('currency').value;
      sendRequestGET('number', 'val=' + value);
  }