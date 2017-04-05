export default ["$location", "$q", function ( $location, $q ) {

    return {
        // optional method
        'response': function (response) {
            // do something on success
            console.log("response")
            console.log(response)
            return response;
        },

        // optional method
        'responseError': function (rejection) {
            // do something on error

            console.log("rejection")
            console.log(rejection)
            if (rejection.status == 401) {
                // $location.url("/login");
                console.log("Do something")
            }

            return $q.reject(rejection);
        }
    }

}]
