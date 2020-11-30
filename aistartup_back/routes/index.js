var express = require('express');
var router = express.Router();
const app = express();
const { upload } = require('./upload');
require('dotenv').config();

// app.post('/uploadOne', upload.single('img'), (req, res) => {
//   console.log(req.file)
// })

router.get('/dotenv', function(req, res, next) {
  res.send(process.env.S3_ACCESS_KEY_ID);
});

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

module.exports = router;
