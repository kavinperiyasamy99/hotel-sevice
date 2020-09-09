node {
stage('Build') {
    echo "Build"
    sh 'mvn clean install'
                  docker.withRegistry('https://registry.hub.docker.com', 'dockerHub') {

                      def customImage = docker.build("kavin24/dockerwebapp")

                      /* Push the container to the custom Registry */
                      customImage.push()
                  }
                  }
}