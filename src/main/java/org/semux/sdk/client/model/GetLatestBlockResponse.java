/*
 * Semux API
 * Semux is an experimental high-performance blockchain platform that powers decentralized application.
 *
 * OpenAPI spec version: 2.5.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.semux.sdk.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.semux.sdk.client.model.ApiHandlerResponse;
import org.semux.sdk.client.model.BlockType;

/**
 * GetLatestBlockResponse
 */

public class GetLatestBlockResponse extends ApiHandlerResponse {
  @JsonProperty("result")
  private BlockType result = null;

  public GetLatestBlockResponse result(BlockType result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  public BlockType getResult() {
    return result;
  }

  public void setResult(BlockType result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLatestBlockResponse getLatestBlockResponse = (GetLatestBlockResponse) o;
    return Objects.equals(this.result, getLatestBlockResponse.result) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLatestBlockResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

