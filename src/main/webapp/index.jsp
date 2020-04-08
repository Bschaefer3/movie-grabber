<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/25/20
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Page</title>

    <script>
        const makeAJAXRequest = (url, callback, contentType) => {
            let xhr = new XMLHttpRequest();

            let method = "get";

            xhr.open(method, url);

            xhr.setRequestHeader('Accept', contentType);

            xhr.send();

            xhr.addEventListener("readystatechange", () => {
                if(xhr.readyState == 4 && xhr.status == 200) {
                    if(xhr.responseXML) {
                        callback(xhr.responseXML);
                    } else {
                        callback(xhr.responseText);
                    }

                }
            })
        }

        const jsonFromServer = () => {

            let url = "/movie_grabber_war/movie/imdbid=tt3659388";
            const callback = data => {
                data = JSON.parse(data);
                console.table(data);
            }
            makeAJAXRequest(url, callback, 'application/json');

        }

        const htmlFromServer = () => {

            let url = "/movie_grabber_war/movie/imdbid=tt3659388";
            const callback = data => {
                console.log(data);
            }
            makeAJAXRequest(url, callback, 'text/html');

        }

    </script>
</head>
<body>
<a href="movie/title=The+Martian">Get movie data</a>
</body>
</html>
