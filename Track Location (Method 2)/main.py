import phonenumbers
from phonenumbers import geocoder
from phonenumbers import carrier
import opencage
from opencage.geocoder import OpenCageGeocode
import folium


key = "7c08bac3344b4927ac0a34bad7d34824" #Geocoder API Key need to paste here "your key" 
number = input("+4915156781587")
new_number = phonenumbers.parse(number)
location = geocoder.description_for_number(new_number, "en")
print(location)

service_name = carrier.name_for_number(new_number,"en")
print(service_name)

geocoder = OpenCageGeocode(key)
query = str(location)
result = geocoder.geocode(query)
#print(result)

lat = result[0]['geometry']['lat']
lng = result[0]['geometry']['lng']

print(lat,lng)

my_map = folium.Map(location=[lat,lng], zoom_start=9)
folium.Marker([lat, lng], popup= location).add_to(my_map)

my_map.save("location.html")

print("location tracking completed")
print("Thank you")