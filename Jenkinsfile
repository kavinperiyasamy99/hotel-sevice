node {
stage('Build') {
    echo "Build"
                  docker.withRegistry('https://hub.docker.com', 'dockerHub') {

                      def customImage = docker.build("hotel-service/dockerwebapp")

                      /* Push the container to the custom Registry */
                      customImage.push()
                  }
                  }
}