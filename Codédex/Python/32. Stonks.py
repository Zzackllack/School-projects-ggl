stock_prices = [34.68, 36.09, 34.94, 33.97, 34.68, 35.82, 43.41, 44.29, 44.65, 53.56, 49.85, 48.71, 48.71, 49.94, 48.53, 47.03, 46.59, 48.62, 44.21, 47.21]

def price_at(i):
    return stock_prices[i-1]
    
def max_price(a,b):
    max1 = 0
    for i in range(a, b+1):
        max1 = max(max1, price_at(i))
    return max1

def min_price(a,b):
    min1 = price_at(a)
    for i in range(a, b+1):
        min1 = min(min1, price_at(i))
    return min1

print(max_price(1, 20))
print(min_price(1, 20))
print(price_at(1))