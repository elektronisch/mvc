package models

import org.codehaus.jackson.annotate.JsonProperty

class Employee {
  @JsonProperty
  var FirstName: String = _

  @JsonProperty
  var LastName: String = _
}

