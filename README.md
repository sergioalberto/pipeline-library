# pipeline-library

Demonstrates how to use a Shared Library in Jenkins pipelines. This repository defines a single function, `sayHello`, which will echo a greeting.

## Setup instructions

1. In Jenkins, go to Manage Jenkins &rarr; Configure System. Under _Global Pipeline Libraries_, add a library with the following settings:

    - Name: `pipeline-library`
    - Default version: Specify a Git reference (branch or commit SHA), e.g. `master`
    - Retrieval method: _Modern SCM_
    - Select the _Git_ type
    - Project repository: `https://github.com/sergioalberto/pipeline-library.git`
    - Credentials: (leave blank)

2. Then create a Jenkins job with the following pipeline (note that the underscore `_` is not a typo):

    ```
    @Library('pipeline-library')_
    stage('Demo') {
      echo 'Hello World'
      sayHello 'Dave'
    }
    ```

This will output the following from the build:

   ```
   [Pipeline] stage
   [Pipeline] { (Demo)
   [Pipeline] echo
   Hello world
   [Pipeline] echo
   Hello, Dave.
   [Pipeline] }
   [Pipeline] // stage
   [Pipeline] End of Pipeline
   Finished: SUCCESS
   ```

3. If you want to test another version from another branch of the library, just add `@` and the `branch name`, for example:

    ```
    @Library('pipeline-library@another-branch')_
    import com.sergiogq.GlobalVars

    stage('Demo') {
      echo 'Hello World'
      sayHello 'Dave'
      println GlobalVars.foo
    }
    ```

   ```
   @Library('my-shared-library@master') _
   /* Using a version specifier, such as branch, tag, etc */
   @Library('my-shared-library@1.0') _
   /* Accessing multiple libraries with one statement */
   @Library(['my-shared-library', 'otherlib@abc1234']) _
   ```

### Resources
- https://www.jenkins.io/doc/book/pipeline/shared-libraries/#legacy-scm
