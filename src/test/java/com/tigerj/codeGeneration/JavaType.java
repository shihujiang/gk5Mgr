package com.tigerj.codeGeneration;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public enum JavaType {
	

	  /*
	   * This is added to enable basic support for the
	   * ARRAY data type - but a custom type handler is still required
	   */
	  ARRAY(Types.ARRAY),
	  BIT(Types.BIT),
	  TINYINT(Types.TINYINT),
	  SMALLINT(Types.SMALLINT),
	  INTEGER(Types.INTEGER),
	  Long(Types.BIGINT),
	  FLOAT(Types.FLOAT),
	  REAL(Types.REAL),
	  DOUBLE(Types.DOUBLE),
	  NUMERIC(Types.NUMERIC),
	  DECIMAL(Types.DECIMAL),
	  CHAR(Types.CHAR),
	  String(Types.VARCHAR),
	  LONGVARCHAR(Types.LONGVARCHAR),
	  DATE(Types.DATE),
	  TIME(Types.TIME),
	  TIMESTAMP(Types.TIMESTAMP),
	  BINARY(Types.BINARY),
	  VARBINARY(Types.VARBINARY),
	  LONGVARBINARY(Types.LONGVARBINARY),
	  NULL(Types.NULL),
	  OTHER(Types.OTHER),
	  BLOB(Types.BLOB),
	  CLOB(Types.CLOB),
	  BOOLEAN(Types.BOOLEAN),
	  CURSOR(-10), // Oracle
	  UNDEFINED(Integer.MIN_VALUE + 1000),
	  NVARCHAR(Types.NVARCHAR), // JDK6
	  NCHAR(Types.NCHAR), // JDK6
	  NCLOB(Types.NCLOB), // JDK6
	  STRUCT(Types.STRUCT),
	  JAVA_OBJECT(Types.JAVA_OBJECT),
	  DISTINCT(Types.DISTINCT),
	  REF(Types.REF),
	  DATALINK(Types.DATALINK),
	  ROWID(Types.ROWID), // JDK6
	  LONGNVARCHAR(Types.LONGNVARCHAR), // JDK6
	  SQLXML(Types.SQLXML), // JDK6
	  DATETIMEOFFSET(-155); // SQL Server 2008

	  public final int TYPE_CODE;
	  private static Map<Integer,JavaType> codeLookup = new HashMap<Integer,JavaType>();

	  static {
	    for (JavaType type : JavaType.values()) {
	      codeLookup.put(type.TYPE_CODE, type);
	    }
	  }

	  JavaType(int code) {
	    this.TYPE_CODE = code;
	  }

	  public static JavaType forCode(int code)  {
	    return codeLookup.get(code);
	  }



}
