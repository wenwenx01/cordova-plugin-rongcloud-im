var exec = require('cordova/exec');

exports.init = function() {
    exec(null, null, "RongCloudIm", "init", []);
};

exports.connect = function(token, success, error) {
    exec(success, error, "RongCloudIm", "connect", [token]);
};

exports.startPrivateChat = function(userId, title) {
    exec(null, null, "RongCloudIm", "startPrivateChat", [userId, title]);
};

exports.startConversationList = function() {
    exec(null, null, "RongCloudIm", "startConversationList", []);
};

exports.startConversationGroupList = function() {
    exec(null, null, "RongCloudIm", "startConversationGroupList", []);
};

