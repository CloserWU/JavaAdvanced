import requests
from bs4 import BeautifulSoup
import json
import sys
# price = json.loads('{"low":"120","high":"250"}')
# print(price)
# r = requests.post("http://47.107.37.58:8080/SSM-JSON/goods/searchprice", json=price)
# print(r.status_code)
# print(r.request)
# demo = r.text
# r_json = json.loads(demo)
# print(r_json)
#
# print(r_json['goods'])

#
# print("=====================================")
# r = requests.get("https://github.com/CloserWU")
# print(r.status_code)
# # print(r.text)
# soup = BeautifulSoup(r.text, "html.parser")
# print(soup.rect)

# f = open('test.html', 'r', encoding='utf-8')
# soup = BeautifulSoup(f.read(), "html.parser")
# print(soup.prettify())
# lists = soup.find_all('rect')
# count = 0
# print(soup.find_all('rect'))
# for i in range(len(lists)) :
#     # print(lists[i])
#     item = lists[i]
#     count += int(item['data-count'])


class GitHubCommit:

    def calcu(self, userName):
        r = requests.get("https://github.com/" + str(userName))
        print(r.status_code)
        soup = BeautifulSoup(r.text, "html.parser")
        # f = open('test.html', 'r', encoding='utf-8')
        # soup = BeautifulSoup(f.read(), "html.parser")
        lists = soup.find_all('rect')
        count = 0
        for i in range(len(lists)):
            # print(lists[i])
            item = lists[i]
            count += int(item['data-count'])

        return str(count)


if __name__ == '__main__':
    userName = str(sys.argv[1])
    main = GitHubCommit()
    print(main.calcu(userName))

