@Integration

Feature: integration test

  Scenario Outline: Integration test
    Given Run application in file mod
      | inputFile  | <inputFile>  |
      | outputFile | <outputFile> |
    Then Verify, that file contains text
      | outputFile | <outputFile> |
      | message    | <message>    |

    Examples:
      | inputFile                                | outputFile                                | message                                                                     |
      | src/Tests/integrationTests/testDataInput | src/Tests/integrationTests/testDataOutput | For your information:\nDear Anton Antonov, we inform you that you should... \n |