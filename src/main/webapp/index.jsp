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
    <title>Movie Grabber</title>

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

        const jsonFromServer = (parameter = "imdbid=tt3659388") => {

            let url = "/movie_grabber_war/movies/" + parameter;
            const callback = data => {
                data = JSON.parse(data);
                console.table(data);
            }
            makeAJAXRequest(url, callback, 'application/json');

        }

        const htmlFromServer = (parameter = "imdbid=tt3659388") => {

            let url = "/movie_grabber_war/movies/" + parameter;
            const callback = data => {
                console.log(data);
            }
            makeAJAXRequest(url, callback, 'text/html');

        }

        const xmlFromServer = (parameter = "imdbid=tt3659388") => {

            let url = "/movie_grabber_war/movies/" + parameter;
            const callback = data => {
                console.log(data);
            }
            makeAJAXRequest(url, callback, 'text/xml');

        }

        const plainTextFromServer = (parameter = "imdbid=tt3659388") => {

            let url = "/movie_grabber_war/movies/" + parameter;
            const callback = data => {
                console.log(data);
            }
            makeAJAXRequest(url, callback, 'text/plain');

        }

    </script>
</head>
<body>
<a href="https://github.com/Bschaefer3/movie-grabber">Link to Github</a>
<a href="https://app.swaggerhub.com/apis-docs/Bschaefer3/movie-grabber/1.0.0">Link to API Documentation</a>
<a href="movies/title=The+Martian">Get movie data</a>
</body>
</html>
