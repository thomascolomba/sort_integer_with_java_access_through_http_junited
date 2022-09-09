# sort\_integer\_with\_java\_access\_through\_http\_junited

A Junit test doing a http GET request to sort\_integer\_with\_java\_access\_through\_http\_junited


-- pom.xml <br/>
dependency : junit (4.12)<br/>

<br/>
-- SortIntegersThroughHttpGetTest.java<br/>
public void testSort() {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String intsToSort = "3,1,2";<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String expectedIntSorted = "[1,2,3]";<br/>
&nbsp;&nbsp;&nbsp;&nbsp;String actualIntSorted = GET "http://localhost:8080/sort_integer_with_java_and_servlet_and_webxml/sortIntegers?intsToSort="+intsToSort;<br/>
&nbsp;&nbsp;&nbsp;&nbsp;assertEquals(expectedIntSorted, actualIntSorted);<br/>
	