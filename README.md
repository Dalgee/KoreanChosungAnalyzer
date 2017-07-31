# 한국어 초성 분석기 for Elasticsearch 5.x

## 준비 사항
elasticsearch 5.x 설치
gradle 설치


## 설치 방법
### 1. Clone this project
```$xslt
```

### 2. Build & packaging(.zip)
```$xslt
gradle 
```

### 3. Install

```$xslt
bin/elasticsearch-plugin install file:///~~~

```

## 테스트 방법

```$xslt
curl -XPUT localhost:9200/merong -d '
{
		"settings" : {
    		"index":{
    			"analysis":{
        			"analyzer":{
        				"korean":{
            			"type":"korean-chosung-analyzer"
        			}
        		}
    		}
    	}
	}
}
'
curl -XGET localhost:9200/merong/_analyze?analyzer=korean-chosung-analyzer&text=메롱

```