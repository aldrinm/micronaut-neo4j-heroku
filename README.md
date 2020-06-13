##build.gradle
To allow Heroku to build and deploy add this to `build.gradle',

    task stage(dependsOn: ['build', 'clean'])
    build.mustRunAfter clean


##Debugging
In the `.env` file add,

    JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005

then run as usual,

    heroku local web
 
##Test endpoint
 Sample endpoint printing the count of neo4j nodes is at `/hello` 
 