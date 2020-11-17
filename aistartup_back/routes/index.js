var express = require('express');
var router = express.Router();
const app = express();
const { upload } = require('./upload');

app.post('/uploadOne', upload.single('img'), (req, res) => {
  console.log(req.file)
})

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

module.exports = router;
