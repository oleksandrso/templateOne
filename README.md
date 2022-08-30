# Project in Allure TestOps with manual & automated tests



# Jenkins job



# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)

Run tests with filled remote.properties:

```bash
gradle clean test
```

Run tests with not filled remote.properties:

```bash
gradle clean regression -DremoteDriverUrl=http://192.168.0.104:4444/wd/hub/ -DvideoStorage=http://192.168.0.104:4444/video/ -Dthreads=5 
```

Serve report:

```bash
allure serve build/allure-results
```

###### For further development there are some example tests in src/test/java/cloud.hopa/tests/demowebshop

* remove @Disabled("...") annotation to run tests

```bash
gradle clean demowebshop
```

