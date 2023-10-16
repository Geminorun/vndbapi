# vndbapi
vndb http



调用接口示例

```java
VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
ResponseBody<Vn> responseBody = apiService.getInfoApi(PathPostfix.VN, vndbFilter);
System.out.println(JsonHelper.serialize(responseBody.results.get(0)));
```

VndbFilter是过滤器，FilterName是过滤名称，FilterOperator是运算符，上述例子的过滤器转化过来就是 ID=17

PathPostfix是枚举，包括了VN、RELEASE、PRODUCER、CHARACTER
