export default ["$location", "$q", function ( $location, $q ) {

    return {
        // optional method
        'response': function (response) {
            // do something on success
            return response;
        },

        // optional method
        'responseError': function (rejection) {
            // do something on error

            if (rejection.status == 401) {
                // $location.url("/login");
                // TODO handle authentication
            }

            return $q.reject(rejection);
        }
    }

}]
