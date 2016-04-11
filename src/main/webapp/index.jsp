<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Shuttle</title>
    <body style="background: cyan">
    <center>
        <h1>::::: Mindfire Sssshuttle :::::</h1>

        <script>  var oFReader = new FileReader();
  oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);

  oFReader.onload = function(oFREvent) {
    document.getElementById("uploadPreview").src = oFREvent.target.result;
  };
</script>

<img id="uploadPreview" style="width: 100px; height: 100px;" />
<input id="uploadImage" type="file" name="myPhoto" onchange="PreviewImage();" />
<script type="text/javascript">
  function PreviewImage() {
    var oFReader = new FileReader();
    oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);

    oFReader.onload = function(oFREvent) {
      document.getElementById("uploadPreview").src = oFREvent.target.result;
    };
  };
</script>
    </center>

</body>
</html>