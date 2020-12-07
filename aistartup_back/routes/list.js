var express = require('express');
const multer = require('multer');
const multerS3 = require('multer-s3');
const AWS = require("aws-sdk");
const {json} = require('express');
const router = express.Router();
const fs = require('fs');
const readline = require('readline');
require('dotenv').config();

AWS.config.update({
    accessKeyId: process.env.S3_ACCESS_KEY_ID,
    secretAccessKey: process.env.S3_SECRET_ACCESS_KEY,
    region: 'ap-northeast-2',
})
const s3 = new AWS.S3();


router.get('/', function (req, res, next) {
    var obj = new Object();
    let json = [];
    obj.image_info = json;
    s3.listObjects({Bucket: 'team01-public'}, function (err, data) {
        if (err) {
            console.log("Error", err);
        } else {
            console.log("Success", data.Contents);
        }
        for (image in data.Contents) {
            const key = data.Contents[image].Key;
            if (key.substr(key.length - 4, 4) === ".csv") continue;
            json.push({
                'name': key,
                'URL': 'https://team01-public.s3.ap-northeast-2.amazonaws.com/' + key
            });
        }
        console.log(obj);
        res.json(obj);
    });
});

router.get('/:search', function(req, res, next) {
    var obj = new Object();
    let json = [];
    obj.image_info = json;
    const label = req.params.search;

    var params = {Bucket: 'team01-public', Key: 'image_info.csv'};


    var lineReader = require('readline').createInterface({
        input: s3.getObject(params).createReadStream()
    })

    lineReader.on('line', function(line) {
        console.log(line)
        if(line.includes(label)){
            json.push({
                'path': line.split(",")[0],
                'label': label
            });
        }
    })
    lineReader.on('close', function(){
        res.json(obj);

    })
    

});


const storage = multerS3({
    s3: s3,
    bucket: 'team01-public',
    contentType: multerS3.AUTO_CONTENT_TYPE,
    acl: 'public-read',
    metadata: function (req, file, cb) {
        cb(null, {fieldName: file.fieldname})
    },
    key: function (req, file, cb) {
        cb(null, 'uploads/${Date.now()}_${file.originalname}')
    },
})


// call S3 to retrieve upload file to specified bucket
// var uploadParams = {Bucket: process.argv[2], Key: '', Body: ''};
// var file = process.argv[3];

// // Configure the file stream and obtain the upload parameters
// var fs = require('fs');
// var fileStream = fs.createReadStream(file);
// fileStream.on('error', function(err) {
//   console.log('File Error', err);
// });
// uploadParams.Body = fileStream;
// var path = require('path');
// uploadParams.Key = path.basename(file);

// // call S3 to retrieve upload file to specified bucket
// s3.upload (uploadParams, function (err, data) {
//   if (err) {
//     console.log("Error", err);
//   } if (data) {
//     console.log("Upload Success", data.Location);
//   }
// });
module.exports = router;
exports.upload = multer({storage: storage});