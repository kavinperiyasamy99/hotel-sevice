pipeline  {
   agent any
   stages{
  stage('Checkout') {
  steps {
    echo "checkout is running"
    }
  }

  stage('Build') {
   steps {
    echo "Build is running"
}
  }

  stage('Unit Tests') {
   steps {
   }
      }


  if( isOnDevelop() || isOnMaster() || !isOnDevelop() ) { return; }

  stage('Promote') {
   steps {
    echo "promote is running"
    }
  }

  if( isOnDevelop() || isOnMaster() || !isOnDevelop() ) {
    return;
  }



  stage('Dev Tests') {
   steps {
    echo "Test Dev"
    }
  }

  stage('Promote') {
   steps {
    echo "Push artifact"
    }
  }
}
 
}

def isOnDevelop(){
  return !env.BRANCH_NAME || env.BRANCH_NAME == 'develop';
}

def isOnMaster(){
   return !env.BRANCH_NAME || env.BRANCH_NAME == 'master';
}

