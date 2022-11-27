# NumberConverter
cflox coding challenge

Implemented as a self-contained app (with all the dependencies baked into one jar file) with an angular frontend.

# Stack
- openjdk 11.0.17
- Apache Maven 3.6.3
- Spring boot 2.7.5
- Angular 15 + angular material

# how to start
download repository and start following command from the project root folder:
```
mvn package && java -jar target/NumberConverter.jar
```
or you can download the ready-to-start jar [here](https://s3.eu-central-1.amazonaws.com/dev.iablokov.cflox.demo/NumberConverter.jar) and start if with:
```
mvn package && java -jar target/NumberConverter.jar
```
frontend will be available under ```localhost:8080```

# how to add new i/o-formats

## new input format

1. Implement interface [InputService.java](src/main/java/dev/iablokov/numberconverter/services/input/InputService.java).
2. Add new service to [InputServiceFactory.java](src/main/java/dev/iablokov/numberconverter/services/input/InputServiceFactory.java).
3. Add new format to enum [DataFormat.java](src/main/java/dev/iablokov/numberconverter/models/DataFormat.java).
4. Add new format to [frontend](src/main/frontend/number-converter-app/src/app/number-converter/components/number-converter/number-converter.component.html).
5. (Optional) [Extend number-converter.component.ts](src/main/frontend/number-converter-app/src/app/number-converter/components/number-converter/number-converter.component.ts) for frontend-side input validation if necessary.
## new output format
1. Implement interface [OutputService.java](src/main/java/dev/iablokov/numberconverter/services/output/OutputService.java).
2. Add new service to [OutputServiceFactory.java](src/main/java/dev/iablokov/numberconverter/services/output/OutputServiceFactory.java).
3. Add new format to enum [DataFormat.java](src/main/java/dev/iablokov/numberconverter/models/DataFormat.java).
4. Add new format to [frontend](src/main/frontend/number-converter-app/src/app/number-converter/components/number-converter/number-converter.component.html).
5. (Optional) [Extend number-converter.component.ts](src/main/frontend/number-converter-app/src/app/number-converter/components/number-converter/number-converter.component.ts) for frontend-side input validation if necessary.
