class Point:
    def __init__(self, x,y):
        self.x = x
        self.y = y

    def dist_from_origin(self):
        return self.x*self.x+self.y*self.y

    def __str__(self):
        return "("+str(self.x)+","+str(self.y)+")"


p1 = Point(5,3)
p2 = Point(5.3,3)
print(p1, p1.dist_from_origin())
print(p2, p2.dist_from_origin())
