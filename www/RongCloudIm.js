var exec = require('cordova/exec');

exports.init = function(success, error) {
    exec(success, error, "RongCloudIm", "init", []);
};

exports.connect = function(arg0, success, error) {
    exec(success, error, "RongCloudIm", "connect", [arg0]);
};
