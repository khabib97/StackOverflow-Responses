var complexData = {
    "status_code": "SUCCESS",
    "status": "SUCCESS",
    "message": "Success",
    "data": [
        {
            "_id": "6034acaaf751f1c89721a76b",
            "status": "active",
            "name": "testname",
            "collectionStatus": "completed",
            "createdDate": 1614064810201,
            "subscriberStats": [],
            "platforms": [
                {
                    "_id": "6034acaa47a83e45b3f5fc4a",
                    "status": "active",
                    "traffic": 0,
                    "parentStatus": "active",
                    "platformType": "website",
                    "appId": "xxx",
                    "optinShowInterval": 0,
                    "optInFrequencyType": "page_refresh",
                    "webType": "wordpress",
                    "optInFrequency": 0,
                    "userId": "xxx",
                    "createdDate": 1614064810563
                }
            ]
        },
        {
            "_id": "600ae310255964c2e21a580f",
            "status": "active",
            "name": "trial",
            "collectionStatus": "completed",
            "createdDate": 1611326224761,
            "subscriberStats": [],
            "platforms": [
                {
                    "_id": "600ae31163d6d321f4693d1d",
                    "status": "active",
                    "traffic": 0,
                    "parentStatus": "active",
                    "platformType": "website",
                    "webType": "wordpress",
                    "appId": "xxx",
                    "optinShowInterval": 0,
                    "optInFrequencyType": "page_refresh",
                    "optInFrequency": 0,
                    "userId": "xxx",
                    "createdDate": 1611326225013
                }
            ]
        }
    ]
};

//console.log(complexData.data[0]);

var convertedData = complexData.data.map(converter);

function converter(data){
	return { appId: data.platforms[0].appId, userId: data.platforms[0].userId };

}

console.log(convertedData);
