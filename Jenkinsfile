pipeline  {
   agent any
  stage('Checkout') {
    echo "checkout is running"
  }

  stage('Build') {
    echo "Build is running"

  }

  stage('Unit Tests') {
      }


  if( isOnDevelop() || isOnMaster() || !isOnDevelop() ) { return; }

  stage('Promote') {
    echo "promote is running"
  }

  if( isOnDevelop() || isOnMaster() || !isOnDevelop() ) {
    return;
  }



  stage('Dev Tests') {
    echo "Test Dev"
  }

  stage('Promote') {
    echo "Push artifact"
  }

 
}

def isOnDevelop(){
  return !env.BRANCH_NAME || env.BRANCH_NAME == 'develop';
}

def isOnMaster(){
   return !env.BRANCH_NAME || env.BRANCH_NAME == 'master';
}

